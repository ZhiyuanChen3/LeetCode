package data.structure;

public class UnionFind_QuickUnion implements UnionFind  {

	private int[] id;
	private int count;

	public UnionFind_QuickUnion(int N) {
		count = N;

		id = new int[N];
		for (int i = 0; i < count; i++) {
			id[i] = i; // all isolated
		}
	}

	@Override
	public int count() {
		return count;
	}
	
	@Override
	public boolean connected(int p, int q) {
		return id[p] == id[q]; // !!!
	}

	@Override
	public int find(int p) {
		// Tree height (could be N)
		while (p != id[p]) p = id[p];
		return p;
	}

	@Override
	public void union(int p, int q) {
		// Tree height (could be N)
		int pRoot = find(p);
		int qRoot = find(q);
		
		if (pRoot == qRoot) return;
		
		pRoot = id[qRoot];
		count--;
	}
}
