package BLOCKCHAIN;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
	
	private List<Block> chain;
	
	public Blockchain() {
		
		chain = new ArrayList<Block>();
		chain.add(generategenesisblock());
	}
	private Block generategenesisblock() {
		Block genesis = new Block("version", new java.util.Date(),"transaction 1");
		genesis.setPreviousHash(null);
		genesis.computeHash();
		return genesis;
	}
	public void addBlock(Block block) {
		block.setPreviousHash(chain.get(chain.size()-1).getHash());
		block.computeHash();
		this.chain.add(block); 
	}
	public void displayChain() {
		for(int i = 0;i<chain.size();i++) {
			System.out.println("Block"+i);
			System.out.println("Version: "+ chain.get(i).getVersion());
			System.out.println("TimeStamp: "+ chain.get(i).getTimestamp());
			System.out.println("PreviousHash: "+ chain.get(i).getPreviousHash());
			System.out.println("Hash: "+ chain.get(i).getHash());
			System.out.println();
			
		}
		
	}
	public Block getLatestBlock() {
		return this.chain.get(chain.size()-1);
	}
	public void isValid() {
		for(int i = chain.size()-1;i>0;i--) {
			if(!chain.get(i).getHash().equals(chain.get(i).computeHash())) {
				System.out.println("Chain in not valid");
				return;
			}
			if(!chain.get(i).getPreviousHash().equals(chain.get(i-1).computeHash())) {
				System.out.println("Chain in not valid");
			return;}
		}
		System.out.println("Chain is valid");
	}


}
