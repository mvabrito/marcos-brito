/**
 *
 */
package br.com.mvabrito.validadorDTO.annotation;

/**
 * @author marcos
 *
 */
public enum Strategy {
//implements Predicate<Object> {

	NOT_NULL {
		@Override
		boolean test(Object... arg) {
			System.out.print("Executing strategy A");
			return arg != null;
		}
	},

	MAX {

		@Override
		boolean test(Object... arg) {
			if (arg == null || arg[0] == null) {
				return true;
			}

			if (arg[0] instanceof Number) {

			}

			System.out.print("Executing strategy B");
			return false;
		}
	};

	abstract boolean test(Object... arg);

//	NOT_NULL(t -> t != null);
//
//	private final Predicate<Object> predicate;
//
//	Strategy(Predicate<Object> predicate, Object... args) {
//		this.predicate = predicate;
//	}
//
//	@Override
//	public boolean test(Object t) {
//		return this.predicate.test(t);
//	}
}
