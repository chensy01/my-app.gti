package mypack;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag extends TagSupport{
	public void HelloTag(){}

	public int doEndTag() throws JspException{
		try{
			pageContext.getOut().print("Hello");
		}catch(Exception ex){
			throw new JspTagException(ex.getMessage());
		}

		return SKIP_BODY;
	}

	public void realease(){
		super.release();
	}
}
