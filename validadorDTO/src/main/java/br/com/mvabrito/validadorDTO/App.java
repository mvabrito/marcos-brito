package br.com.mvabrito.validadorDTO;

import java.util.List;

import br.com.mvabrito.validadorDTO.annotation.ValidatorService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ExemploVO ex = new ExemploVO();

		ex.setNome("AAAAAAAA");
		ex.setEnd("BBBBBBB");
		List<String> l = ValidatorService.process(ex);
		l.stream().forEach(System.out::println);
	}
}
