package it.contrader.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import it.contrader.service.ServiceDTO;

/**
 * In questa classe sono implementati tutti i metodi di CRUD dei Controller, paramentrizzati dal tipo
 * generico. Nella classe viene dichiarata l'interfaccia ServiceDTO<DTO>.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 *
 *@param <DTO>
 *

 * 
 * @see ServiceDTO<DTO>
 */
@Controller
public abstract class AbstractController <DTO>{
	@Autowired
	private ServiceDTO<DTO> service;

	@GetMapping("/getall")
	public Iterable<DTO> getAll(){
		return service.getAll();
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") long id) {
		service.delete(id);
	}

	@PutMapping("/update")
	public DTO update(@RequestBody DTO dto){
		return service.update(dto);
	}

	@PostMapping("/insert")
	public DTO insert (@RequestBody DTO dto) {
		return service.insert(dto);
	}

	@GetMapping("/read")
	public DTO read(@RequestParam long id) {
		return service.read(id);
	}

	@GetMapping("/getallpaged")
	public Page<DTO> getDtoPage(@RequestParam int pageNumber, @RequestParam int pageSize ){
		return service.toDtoPage(PageRequest.of(pageNumber, pageSize));
	}
}