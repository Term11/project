package bwf.teaching.book.web.action.manage;

import java.io.InputStream;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller("downloadTXLAction")
@Scope("prototype")
public class DownloadTXLAction extends ActionSupport {
	
	private InputStream txlFile;
	private String fn;
	
	@Override
	public String execute() throws Exception {
		fn = "员工通讯录.xlsx";
		fn = URLEncoder.encode(fn, "utf-8");
		txlFile = ServletActionContext.getServletContext().getResourceAsStream("/WEB-INF/res/员工通讯录.xlsx");
		return SUCCESS;
	}

	public InputStream getTxlFile() {
		return txlFile;
	}

	public void setTxlFile(InputStream txlFile) {
		this.txlFile = txlFile;
	}

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}
}
