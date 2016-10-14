package br.com.sgi.model.exception;

//Toda RuntimeException causa Rollback e é do tipo System Exception
public class SgiExceptionComRollback extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
