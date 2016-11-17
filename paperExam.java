import java.util.Scanner;

public class paperExam {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
            int count  = 1;
			boolean check = true;
			String s1 = new String("STOP");

			while(check) {
				System.out.print("Please enter a sentence: " );
					String sentence = scan.nextLine();

						if(sentence.equals(s1)) {
							check = false;
						}


						else if(sentence.length()>=9) {
							System.out.println("Sentence entered is: " +sentence);

								for(int i =0; i<=sentence.length()-1; i++) {
									if(sentence.charAt(i) == ' ') {
										System.out.println(" ");
											count++;
									}

									else System.out.print(sentence.charAt(i));
								}

								System.out.println();

								System.out.println("The number of words in the sentence is " +count);

									System.out.println("The sentence in uppercase is: " +sentence.toUpperCase());
										System.out.println("The sentence in lowercase is: " +sentence.toLowerCase());

								System.out.print("The sentence in reverse is: " );

									for(int j = sentence.length()-1; j>=0; j--) {
										System.out.print(sentence.charAt(j));
									}

									System.out.println();
						}

						else {
							System.out.println("The sentence does not have at leats 10 characters.");
						}
			}
	}
}