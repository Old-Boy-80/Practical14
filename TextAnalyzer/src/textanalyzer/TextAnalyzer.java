/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package textanalyzer;

/**
 *
 * @author lpjad
 */
public class TextAnalyzer {

    /**
     * @param args the command line arguments
     */
    
    private String inputtedText;
    private int wordCount;
    private int tabCount;
    private int spaceCount;
    private int lineCount;
    private int textLength;
    private String uniqueChars = "";
    
    public TextAnalyzer(String inputtedText) {
        this.inputtedText = inputtedText;
        analyzeText();       
    }

    public String getInputtedText() {
        return inputtedText;
    }


    public int getWordCount() {
        return wordCount;
    }

    public int getTabCount() {
        return tabCount;
    }

    public int getSpaceCount() {
        return spaceCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getTextLength() {
        return textLength;
    }

    public String getUniqueChars() {
        return uniqueChars;
    }
    
    public int getTextCount(String pattern) {
        int count = 0;
        String[] wordList = inputtedText.splitWithDelimiters("[ \t\n]", -1);
        for(int i = 0; i < wordList.length; i++) {
            if(pattern.equals(wordList[i])) count++;
        }
        return count;
    }
    
    public int getCharCount(char ch) {
        int count = 0;
        for(int i = 0; i< textLength; i++) {
            if(inputtedText.charAt(i) == ch) count++;
        }
        return count;
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new TextAnalyzerGUI().setVisible(true);
//        String text = " ab Bc\tD\nda\t  ";
//        TextAnalyzer text1 = new TextAnalyzer(text);
//        System.out.println(4);
//        System.out.println(text1.getTextOrCharCount("Bc"));
        
    }

    @Override
    public String toString() {
        return "TextAnalyzer:\n" + "inputtedText=" + inputtedText + "\n wordCount=" + wordCount + "\n tabCount=" + tabCount + "\n spaceCount=" + spaceCount + "\n lineCount=" + lineCount + "\n textLength=" + textLength + "\n uniqueChars=" + uniqueChars;
    }
    

    private void analyzeText() {
        textLength = inputtedText.length();
        String[] words = inputtedText.split("[\\n\\t\\s]", -1);
        for(int i = 0; i< words.length; i++) {
            if(words[i].isBlank()) continue;
            wordCount++;
        }

        if(textLength == 0) lineCount = 0;
        else lineCount = 1;
        
        for(int i = 0; i < textLength; i++) {
            char ch = inputtedText.charAt(i);
            if(ch == '\s') {
                spaceCount++;
            }
            if(ch == '\t' ) {
                tabCount++;
            }
            
            if(ch == '\n') {
                lineCount++;
            }
            
            if(!uniqueChars.contains(ch+"") && !((ch+"").isBlank())) {
                uniqueChars += ch;
            }
            
        }
    }
    
}
