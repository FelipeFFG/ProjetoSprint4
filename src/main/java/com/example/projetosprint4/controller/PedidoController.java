package com.example.projetosprint4.controller;

import com.example.projetosprint4.controller.dto.PedidoDto;
import com.example.projetosprint4.controller.form.PedidoForm;
import com.example.projetosprint4.model.Pedido;
import com.example.projetosprint4.repository.PedidoRepository;
import com.example.projetosprint4.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/protected/pedido")
public class PedidoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;


    @PostMapping()
    @Transactional
    public ResponseEntity<?> cadastrarPedido(@Valid @RequestBody PedidoForm pedidoForm) {
        if (pedidoForm != null) {
            Pedido produtos = pedidoForm.save(produtoRepository, pedidoRepository);
            List<Pedido> pedido = new ArrayList<>();
            pedido.add(produtos);
            return new ResponseEntity<>(new PedidoDto().converteListaPedidos(pedido), HttpStatus.CREATED);
        }
        return ResponseEntity.notFound().build();
    }

    //busca todos os pedidos se estiver ativo
    @GetMapping()
    public ResponseEntity<List<PedidoDto>> buscarPedidos() {
        List<Pedido> lista_pedidos = pedidoRepository.findAll();
        List<Pedido> pedidosAtivos = new ArrayList<>();
        if (!lista_pedidos.isEmpty()) {
            for (int i = 0; i < lista_pedidos.size(); i++) {
                if (lista_pedidos.get(i).isStatus() == true) {
                    pedidosAtivos.add(lista_pedidos.get(i));
                }
            }
            if (pedidosAtivos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(new PedidoDto().converteListaPedidos(pedidosAtivos));
        } else
            return ResponseEntity.notFound().build();
    }

    //busca os pedidos por Id se estiver ativo
    @GetMapping({"/{id}"})
    public ResponseEntity<List<PedidoDto>> buscarPedidosPorId(@PathVariable Long id) {
        List<Pedido> lista_pedidos = pedidoRepository.findPedidoById(id);
        if (!lista_pedidos.isEmpty()) {
            return ResponseEntity.ok(new PedidoDto().converteListaPedidos(lista_pedidos));
        } else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDto> alterarCadastro(@PathVariable Long id, @Valid @RequestBody PedidoForm produtoForm) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            Pedido pedidoAtualizado = produtoForm.atualizar(id, pedidoRepository, produtoRepository);
            PedidoDto pedidoDto = new PedidoDto();
            return ResponseEntity.ok(pedidoDto.converte(pedidoAtualizado));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarPedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            PedidoForm pedidoForm = new PedidoForm();
            pedidoForm.deletar(id, pedidoRepository);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
