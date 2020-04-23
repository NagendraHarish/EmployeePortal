package com.nttdata.EmployeePortal.properties;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix = "portal.mail")
@Validated
public class EmailProperties {

	@Email
	  private String to;
	@NotBlank
	  private String host;
	  private int port;
	  private String[] cc;
	  private List<String> bcc;
	  private final Map<String,Integer> items = new HashMap<>();
	  @Valid
	  private Credential credential = new Credential();
	  
	  public class Credential {
		    @NotBlank
		    private String userName;
		    @Size(max = 15, min = 6)
		    private String password;
			public String getUserName() {
				return userName;
			}
			public void setUserName(String userName) {
				this.userName = userName;
			}
			public String getPassword() {
				return password;
			}
			public void setPassword(String password) {
				this.password = password;
			}

		  }

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public List<String> getBcc() {
		return bcc;
	}

	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

	public Map<String, Integer> getItems() {
		return items;
	}
	  
}
