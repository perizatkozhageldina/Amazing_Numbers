class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < 26; i++) {
            char ch = 'A';
            ch += i;
            str.append(ch);
            str.append(" ");
        }
        str.delete(51,52);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(createEnglishAlphabet());
    }
}