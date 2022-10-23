package com.cruzeiro;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Como ele é respectivamente tudo relacionado a empregados, iremos passar o @RequestMapping
// o @RequestMapping ele vai obedecer tudo que for a respeito de epregados ele tem que começar com /employee
// Por isso que na main-page foi colocado um link /employee/showPage -> o primeiro mapeamento é referente a esse request e temos o mapeamento do showForm
// O mapeamento do showForm vem dentro dessa pagina
@RequestMapping("/employee")
public class EmployeeController {
	
//	O employController e o initBinder faz a trativa dos campos. Porque o InitBinder vai pegar todos os elementos que foi setado no Employee-form e ele vai fazer uma trativa no controller
	@InitBinder
	public void initBinder(WebDataBinder preenchimentoCampo) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		preenchimentoCampo.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
//	Esse mapeamento do /showForm vai pegar todos os elementos. Eu quero pegar o objeto java Employee e eu quero carregar ele como modelo para a pagina que vai recebelo
//	Porque como a gente vai trabalhar  com framework, quando eu carregar o meu jsp eu vou ter embutido nessa pagina jsp as caracteristicas do objeto Employee
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Employee employee = new Employee();

//		O primeiro valor é o que vai levar para a pagina que vai receber
//		Ou seja um objeto que vai ser levado para a pagina employee-form
//		Estou colocando o objeto employee no elemento employee-form, ou seja os campos que o Employee tem
		model.addAttribute("employee", employee);
		return "employee-form";
	}
	
//	Essa pagina vai receber as informaçoes do employee-form, que agora vai fazer o mapeamento pro processForm para exibir os dados enviados
		@RequestMapping("/processForm")
		public String processForm(
//				Validaçao do atributo
				@Valid @ModelAttribute("employee") Employee employee,
//				Resultado que vai ser blindado
				BindingResult validationRules) 
		{
//			Validaçao dos elementos
//			Se as validaçoes la na classe Employee não passar ele volta pra tela de registrar empregado se nao vai paa um tela de sucesso, 
			if(validationRules.hasErrors()) {
				return "employee-form";
			}else {
				return "employee-confirmation";
			}
		}
	

}
