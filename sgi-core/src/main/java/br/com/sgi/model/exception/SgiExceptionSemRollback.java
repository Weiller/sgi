package br.com.sgi.model.exception;

import javax.ejb.ApplicationException;

//Toda Exception é do tipo Application Exception e não causa rollback
@ApplicationException(rollback=false) //opcional
public class SgiExceptionSemRollback extends Exception {

	private static final long serialVersionUID = 1L;

}
