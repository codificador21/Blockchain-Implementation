package BLOCKCHAIN;

public class TestChain {
	public static void main(String[] args) {
		Blockchain bitcoin = new Blockchain();
		
		Block a = new Block("a", new java.util.Date(),"transaction 1");
		Block b = new Block("b", new java.util.Date(), "transaction 2");
		Block c = new Block("c", new java.util.Date(), "transaction 4");
		
		bitcoin.addBlock(a);
		bitcoin.addBlock(b);
		bitcoin.addBlock(c);
		
		bitcoin.displayChain();

	}
}
