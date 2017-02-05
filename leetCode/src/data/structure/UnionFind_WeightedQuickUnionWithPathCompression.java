package data.structure;

public class UnionFind_WeightedQuickUnionWithPathCompression implements UnionFind  {

	private int[] id;
	private int[] sz;
	private int count;

	public UnionFind_WeightedQuickUnionWithPathCompression(int N) {
		count = N;

		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < count; i++) {
			id[i] = i; // all isolated
			sz[i] = 1;
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
		// Very near to 1 (amortized)
		while (p != id[p]) {
			id[p] = id[id[p]]; // only one line added
			p = id[p];
		}
		return p;
	}

	@Override
	public void union(int p, int q) {
		// Very near to 1 (amortized)
		int pRoot = find(p);
		int qRoot = find(q);
		
		if (pRoot == qRoot) return;
		
		if (sz[pRoot] < sz[qRoot]) {
			sz[qRoot] += sz[pRoot];
			qRoot = id[pRoot];
		} else {
			sz[pRoot] += sz[qRoot];
			pRoot = id[qRoot];
		}
		count--;
	}
}
