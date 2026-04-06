class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> cols = new ArrayList<>(9);
        List<Set<Character>> boxes = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }        

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                Set<Character> row = rows.get(i);
                Set<Character> col = cols.get(j);
                Set<Character> box = boxes.get(getBoxIndex(i,j));

                char val = board[i][j];

                // skip empty character
                if ('.' == val) continue;

                if (row.contains(val)) return false;
                row.add(val);

                if (col.contains(val)) return false;
                col.add(val);

                if (box.contains(val)) return false;
                box.add(val);
            }
        }

        return true;
    }

    private static int getBoxIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
}
