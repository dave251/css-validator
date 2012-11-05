// $Id$
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;

/**
 * @spec http://www.w3.org/TR/2007/WD-css3-box-20070809/#overflow-y
 * @see org.w3c.css.properties.css3.CssOverflow
 */
public class CssOverflowY extends org.w3c.css.properties.css.CssOverflowY {

	/**
	 * Create a new CssOverflowY
	 */
	public CssOverflowY() {
	}

	/**
	 * Creates a new CssOverflowY
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssOverflowY(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		setByUser();
		value = CssOverflow.checkOverflowAxis(ac, expression, check, this);
	}

	public CssOverflowY(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}


}

