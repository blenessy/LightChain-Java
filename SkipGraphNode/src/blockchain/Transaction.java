package blockchain;

import java.util.ArrayList;

import hashing.Hasher;
import hashing.HashingTools;
import skipGraph.NodeInfo;
import skipGraph.SkipNode;

public class Transaction extends NodeInfo{
	
	private static final long serialVersionUID = 1L;
	private final String prev;
	private final int owner;
	private final String cont;//Use random string for this
	private final String h;//Hash
	private ArrayList<String> sigma;
	private Hasher hasher;
	
	// need to add address to transaction
	
	public Transaction(String prev, int owner, String cont,String address){
		super(address,0,prev);
		this.prev = prev;
		this.owner = owner;
		this.cont = cont;
		hasher = new HashingTools();
		this.h = hasher.getHash(prev + owner + cont,SkipNode.TRUNC);
		super.setNumID(Integer.parseInt(this.h,2));
	}
	
	public ArrayList<String> getSigma(){
		return sigma;
	}
	
	public String getPrev() {
		return prev;
	}
	
	public int getOwner() {
		return owner;
	}
	public String getCont() {
		return cont;
	}
	public String getH() {
		return h;
	}
	public void setSigma(ArrayList<String> s) {
		sigma = s;
	}
	public String toString() {
		return prev + owner + cont + getAddress();
	}
	
		
}
