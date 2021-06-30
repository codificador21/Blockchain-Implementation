package BLOCKCHAIN;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;

public class Block {
	
	private String version;
	private java.util.Date Timestamp;
	private String Hash;
	private String previousHash;
	private String data;
	
	public Block(String version, java.util.Date Timestamp,String data) {
		this.version = version;
		this.Timestamp = Timestamp;
		this.data = data;
		this.Hash = computeHash();
	}
	
	public String computeHash() {
		
		String datatoHash = ""+this.version + this.Timestamp+this.previousHash+this.data;
		
		MessageDigest digest;
		String encoded = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(datatoHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		this.Hash = encoded;
		return encoded;
		
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public java.util.Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}

	public String getHash() {
		return Hash;
	}

	public void setHash(String hash) {
		Hash = hash;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
