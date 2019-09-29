/**
 *
 */
package br.com.mvabrito.validadorDTO.annotation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Marcos Vinícius Azeredo de Brito
 *
 */
public class ValidatorService {

	private static void extracted(Object t, List<String> erros, Field f, ValidateField validateField)
			throws IllegalAccessException {
		Object value = f.get(t);
		Parametro parametro = validateField.parametro();
		if (!parametro.strategy().NOT_NULL.test(value)) {
			erros.add(f.getName() + " -- " + f.get(t) + " -- " + parametro.variaveis());
		}
	}

	public static List<String> process(Object t) {

		List<String> erros = new ArrayList<String>();
		List<Field> fiels = Arrays.asList(t.getClass().getDeclaredFields());
		fiels.stream().forEach(f -> {
			AccessibleObject.setAccessible(new AccessibleObject[] { f }, true);

			Arrays.asList(f.getAnnotations()).stream().forEach(annotation -> {

				Object ob = f.getAnnotation(NotNull.class);

				System.out.println("XXXXXXXX " + ob);

//				System.out.println("1" + annotation.annotationType().getSimpleName());
//				System.out.println("2" + annotation.annotationType().getCanonicalName());
//				System.out.println("3" + annotation.annotationType().getComponentType());
//				System.out.println("4" + annotation.annotationType().getDeclaringClass());
//				System.out.println("5" + annotation.annotationType().getTypeName());
//				System.out.println("6" + annotation.annotationType().getTypeParameters());

				if (annotation.annotationType().getSimpleName().equals(NotNull.class.getSimpleName())) {
					TypeVariable<?>[] a = annotation.annotationType().getTypeParameters();
					Arrays.asList(a).stream().forEach(b -> {
						System.out.println(b.getBounds());
						System.out.println(b.getName());
						System.out.println(b.getTypeName());
					});
				}

			});

			ValidateField validateField = f.getAnnotation(ValidateField.class);
			try {
				if (validateField != null) {
					extracted(t, erros, f, validateField);
				}

			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return erros;

	}

//	private T t;
//
//	public ValidatorService(T t) {
//		this.t = t;
//	}

}
