/**
 *
 */
package br.com.mvabrito.validadorDTO.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ FIELD })
/**
 * @author Marcos Vinícius Azeredo de Brito
 *
 */
public @interface ValidateField {
	Parametro parametro();
}
