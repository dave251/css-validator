//
// $Id$
// From Sijtsche de Jong (sy.de.jong@let.rug.nl)
//
// (c) COPYRIGHT 1995-2000  World Wide Web Consortium (MIT, INRIA, Keio University)
// Please first read the full copyright statement at
// http://www.w3.org/Consortium/Legal/copyright-software-19980720

package org.w3c.css.properties.css3;

import org.w3c.css.parser.CssStyle;
import org.w3c.css.properties.css1.CssProperty;
import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssIdent;
import org.w3c.css.values.CssValue;

/**
 *  <P>
 *  <EM>Value:</EM> auto || autosense-script || no-change || reset-size ||
 *  ideographic || alphabetic || hanging || mathematical || inherit<BR>
 *  <EM>Initial:</EM>auto<BR>
 *  <EM>Applies to:</EM>inline-level elements<BR>
 *  <EM>Inherited:</EM>no<BR>
 *  <EM>Percentages:</EM>no<BR>
 *  <EM>Media:</EM>:visual
 *  <P>
 *  The 'dominant-baseline' property is used:
 *   <UL>
 *     <LI>to determine the dominant baseline
 *     <LI>to select the baseline-table
 *     <LI>to establish the font-size used with the baseline-table
 *   </UL>
 */

public class CssDominantBaseLine extends CssProperty {

    CssValue dombaseline;

    static CssIdent auto = new CssIdent("auto");

    private static String[] values = {
	"auto", "use-script", "no-change", "reset-size",
	"ideographic", "alphabetic", "hanging", "mathematical",
	"central", "middle", "text-after-edge", "text-before-edge",
	"inherit", "initial"
    };

    /**
     * Create a new CssDominantBaseLine
     */
    public CssDominantBaseLine() {
	dombaseline = auto;
    }

    /**
     * Create a new CssDominantBaseLine
     *
     * @param expression The expression for this property
     * @exception InvalidParamException Incorrect value
     */
    public CssDominantBaseLine(ApplContext ac, CssExpression expression,
	    boolean check) throws InvalidParamException {

	setByUser();
	CssValue val = expression.getValue();

	int i = 0;
	for (; i < values.length; i++) {
	    if (val.toString().equals(values[i])) {
		dombaseline = val;
		expression.next();
		break;
	    }
	}
	if (i == values.length) {
	    throw new InvalidParamException("value", expression.getValue(),
					    getPropertyName(), ac);
	}
    }

    public CssDominantBaseLine(ApplContext ac, CssExpression expression)
	    throws InvalidParamException {
	this(ac, expression, false);
    }
    
    /**
     * Add this property to the CssStyle
     *
     * @param style The CssStyle
     */
    public void addToStyle(ApplContext ac, CssStyle style) {
	if (((Css3Style) style).cssDominantBaseLine != null)
	    style.addRedefinitionWarning(ac, this);
	((Css3Style) style).cssDominantBaseLine = this;
    }

    /**
     * Get this property in the style.
     *
     * @param style The style where the property is
     * @param resolve if true, resolve the style to find this property
     */
    public CssProperty getPropertyInStyle(CssStyle style, boolean resolve) {
	if (resolve) {
	    return ((Css3Style) style).getDominantBaseLine();
	}
	else {
	    return ((Css3Style) style).cssDominantBaseLine;
	}
    }

    /**
     * Compares two properties for equality.
     *
     * @param value The other property.
     */
    public boolean equals(CssProperty property) {
	return (property instanceof CssDominantBaseLine &&
		dombaseline.equals(((CssDominantBaseLine) property).dombaseline));
    }

    /**
     * Returns the name of this property
     */
    public String getPropertyName() {
	return "dominant-baseline";
    }

    /**
     * Returns the value of this property
     */
    public Object get() {
	return dombaseline;
    }

    /**
     * Returns true if this property is "softly" inherited
     */
    public boolean isSoftlyInherited() {
	return dombaseline.equals(inherit);
    }

    /**
     * Returns a string representation of the object
     */
    public String toString() {
	return dombaseline.toString();
    }

    /**
     * Is the value of this property a default value
     * It is used by alle macro for the function <code>print</code>
     */
    public boolean isDefault() {
	return (dombaseline == auto);
    }

}

