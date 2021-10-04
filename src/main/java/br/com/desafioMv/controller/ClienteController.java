package br.com.desafioMv.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.desafioMv.entity.Cliente;
import br.com.desafioMv.service.ClienteService;

@Controller
@ResponseBody
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/clientes", method = RequestMethod.GET)
	private List<Cliente> getClientes() {

		return clienteService.listarTodos();
	}

	@RequestMapping(value = "/clienteById/{id}", method = RequestMethod.GET)
	private ResponseEntity<Cliente> getClientePorID(@PathVariable(value = "id") Integer id) {

		Optional<Cliente> cliente = clienteService.getClientePorId(id);

		if (cliente.isPresent()) {
			return new ResponseEntity<Cliente>(cliente.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/atualizarCliente", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> Put(@RequestBody Cliente cliente)
    {
    	Optional<Cliente> clienteOpt = clienteService.getClientePorId(cliente.getId());
    	
    	if(clienteOpt.isPresent()){
    		Cliente cliente2 = clienteService.atualizarCliente(clienteOpt.get());
        return new ResponseEntity<Cliente>(cliente2, HttpStatus.OK);
        
    	}else {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
    	}
    }

	@RequestMapping(value = "/deleteCliente/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") Integer id) {
		Optional<Cliente> cliente = clienteService.getClientePorId(id);

		if (cliente.isPresent()) {
			clienteService.deletarCliente(cliente.get());
			return new ResponseEntity<>(HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	 @RequestMapping(value = "/cliente", method =  RequestMethod.POST)
	    public Cliente Post(@RequestBody Cliente cliente)
	    {
	        return clienteService.inserirCliente(cliente);
	    }
}
