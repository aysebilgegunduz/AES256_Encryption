package HW2;

import java.security.SecureRandom;
import java.util.Arrays;

import edu.rit.crypto.blockcipher.AES256Cipher;
import edu.rit.pj.ParallelRegion; 
import edu.rit.pj.ParallelTeam;
import edu.rit.util.Hex;

public class EncJavaParallel2 {
	
	public static String encrypt(int index, String keyStr, byte[] messageByteBlock)
    {
        
        byte[] key = Hex.toByteArray(keyStr);
        AES256Cipher cipher = new AES256Cipher(key);
        String encryptedMessage = "";
        
        cipher.encrypt(messageByteBlock);
        encryptedMessage = Hex.toString(messageByteBlock);
        
        return encryptedMessage;
    }
	
	static long start;   
	static long end; 
    static long startTimes[];     
    static long endTimes[];
    static String keyStr; 
    static String message =  "Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborative tool Augusta Ada King Noel Countess of Lovelace was an English mathematician and writer chiefly "
				+ "known for her work on Charles Babbages proposed mechanical genera purpose computer the Analytical"
				+ " Engine She was the first to recognise that the machine had applications beyond pure calculation, and"
				+ " created the first algorithm intended to be carried out by such a machine As a result she is often regarded"
				+ " as the first to recognise the full potential of a computing machine and the first computer programmer Ada "
				+ "Lovelace was the only legitimate child of the poet George Lord Byron and his wife Anne Isabella "
				+ "Milbanke Annabella Lady Wentworth All Byrons other children were born out of wedlock to other women"
				+ "Byron separated from his wife a month after Ada was born and left England forever four months later eventually"
				+ " dying of disease in the Greek War of Independence when Ada was eight years old Her mother remained bitter "
				+ "towards Lord Byron and promoted Ada's interest in mathematics and logic in an effort to prevent her from "
				+ "developing what she saw as the insanity seen in her father but Ada remained interested in him despite this "
				+ "Often ill she spent most of her childhood sick Ada married William King in 1835 King was made Earl of Lovelace "
				+ "in 1838 and she became Countess of Lovelace Her educational and social exploits brought her into contact with "
				+ "scientists such as Andrew Crosse, Sir David Brewster, Charles Wheatstone, Michael Faraday and the author Charles "
				+ "Dickens, which she used to further her education Ada described her approach as poetical science and herself as an Analyst"
				+ " When she was a teenager, her mathematical talents led her to a long working relationship and "
				+ "friendship with fellow British mathematician Charles Babbage, also known as the father of computers, "
				+ "and in particular, Babbages work on the Analytical Engine. Lovelace first met him in June 1833, "
				+ "through their mutual friend, and her private tutor, Mary Somerville. Between 1842 and 1843, Ada "
				+ "translated an article by Italian military engineer Luigi Menabrea on the engine, which she "
				+ "supplemented with an elaborate set of notes, simply called Notes. These notes contain what many "
				+ "consider to be the first computer program—that is, an algorithm designed to be carried out by a "
				+ "machine. Lovelace's notes are important in the early history of computers. She also developed a "
				+ "vision of the capability of computers to go beyond mere calculating or number-crunching, while many "
				+ "others, including Babbage himself, focused only on those capabilities. Her mindset of poetical "
				+ "science led her to ask questions about the Analytical Engine examining how individuals and society "
				+ "relate to technology as a collaborat";
    static byte[] messageBytes = message.getBytes();
    
    public static void main(String[] args) throws Exception {
    	start = System.currentTimeMillis();         
        startTimes = new long[messageBytes.length/16];         
        endTimes = new long[messageBytes.length/16]; 
        ParallelTeam team = new ParallelTeam(messageBytes.length/16);         
    	team.execute(new ParallelRegion() { 
        
    		public void run() {
    	    	int i = getThreadIndex();
    	    	startTimes[i] = System.currentTimeMillis();
    	    	byte[] messageByteBlock = new byte[16];
    	    	keyStr = Hex.toString(SecureRandom.getSeed(32));
    	    	messageByteBlock = Arrays.copyOfRange(messageBytes, i*16, ((i+1)*16));
    	    	encrypt(i, keyStr, messageByteBlock);      	
    	    	endTimes[i] = System.currentTimeMillis();     
    	    }         
    	});   
    	end =System.currentTimeMillis();
    	System.out.println("time difference:     " + (end-start));
    	/*
    	for (int i = 0; i < messageBytes.length/16; i++) {             
    		System.out.println(i + " start: "+ (startTimes[i]-start) );             
    		System.out.println(i + " end:   "+ (endTimes[i]-start) );         
    	}     
    	*/
    }

}
