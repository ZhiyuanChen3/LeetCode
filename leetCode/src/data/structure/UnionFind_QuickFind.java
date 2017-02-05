package data.structure;

public class UnionFind_QuickFind implements UnionFind { // 并查集
	
	private int[] id; // access to component id
	private int count; // number of components

	public UnionFind_QuickFind(int N) {
		// initialize component id array
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i; // initial state: all components isolated
		}
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	
	@Override
	public int find(int p) {
		// 1
		return id[p];
	}

	@Override
	public void union(int p, int q) {
		// N
		int pID = find(p);
		int qID = find(q);

		if (pID == qID)
			return;
		else {
			for (int i = 0; i < id.length; i++) {
				if (id[i] == pID)
					id[i] = qID;
			}
			count--;
		}
	}
	// issue: adding a new edge, i.e., changing group id, has to traverse the array --> O(n)
	//        adding N new edges, given M nodes ---> O(NM)
}
