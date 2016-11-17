package test;


import env.FontProviderFactory;

public class Test {
	public static void main(String[] args) {
		String[] ss = FontProviderFactory.getFontNameProvider().getAllFonts();
		for (String s : ss) {
			System.out.println(s);
		}
	}
}
