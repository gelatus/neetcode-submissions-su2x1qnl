class Solution {

    public String encode(List<String> strs) {
        StringBuilder strbuf = new StringBuilder();
        for (String str: strs) {
            String hex = String.format("%02X", str.length());
            strbuf.append(hex);
            strbuf.append(str);
        }
        return strbuf.toString();
    }

    public List<String> decode(String str) {
        int idx=0;
        List<String> result = new ArrayList<>();

        while(idx < str.length()) {
            String hex = str.substring(idx, idx+2);
            idx += 2;
            int sz = Integer.parseUnsignedInt(hex,16);
            String s = str.substring(idx, idx + sz);
            idx += sz;
            result.add(s);
        }

        return result;
    }
}
