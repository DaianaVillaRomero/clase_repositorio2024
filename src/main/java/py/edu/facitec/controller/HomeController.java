package py.edu.facitec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//A notacion "@" provee informacion adicional a una clase, atributo o metodo 
//un elemento que atienda peticiones y envie respuestas necesitamos indicar "@controller"

//peticiones ---> request lo que viene del cliente 
//Respuestas ---> response lo que sale del servidor 

@Controller
public class HomeController {
	
	//Puede existir varios metodos para entender determinadas peticiones
	//Get ---> se visualiza la escritura en el navegador
	
	@GetMapping("/home") //request
	
	public String home() {
		
		
	System.out.println("Llegue hasta el controlador");
		
		//static      /archivo/       inde               .html          
		//defecto      ap.proper      controller       ap.proper
		
		return "index";   //response
	}
	
	

}
