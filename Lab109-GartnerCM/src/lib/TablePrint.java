package lib;

/*
 * Copyright 2021 Cole Gartner.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Can take multiple arrays in and display a customizable table.
 *
 * @author Cole Gartner
 * @version Oct 14, 2021
 */
public class TablePrint {
    
    private String title;
    
    private String[] topics;
    
    // The margin between boarders and arguments.
    private final int margin = 2;
    
    /**
     * Creates a new table print object with a title and number of topics.
     * @param t title
     * @param topicNames names of topic
     */
    public TablePrint (String t, String... topicNames) {
        title = t;
        topics = new String[topicNames.length];
        for (int i = 0; i < topicNames.length; i++) topics[i] = topicNames[i];
    }
    
    /**
     * Returns a printout of title, topics and an int argument array under topics
     * in a table format that is equally spaced
     * The value of values.length must equal the value of topics.length.
     * @param values int array of values under topics
     * @return printout
     * @throws IllegalArgumentException values.length != topics.length
     */
    public String print(int[]... values) throws IllegalArgumentException {
        if (values.length != topics.length)
            throw new IllegalArgumentException(values.length+"!="+topics.length);
        
        StringBuilder table = new StringBuilder();
        int[] maxTopicWidth = new int[values.length];
        for (int i = 0; i < values.length; i++) { // Iterate on topics
            for (int j = 0; j < values[i].length; j++) { // Iterate inside topics
                if (String.valueOf(values[i][j]).length() > maxTopicWidth[i])
                    maxTopicWidth[i] = String.valueOf(values[i][j]).length();
            }
        }
        for (int i = 0; i < maxTopicWidth.length; i++) { // Adds commas to the width
            if (maxTopicWidth[i] >= 10) maxTopicWidth[i] += 3; // Billions
            else if (maxTopicWidth[i] >= 7) maxTopicWidth[i] += 2; // Millians
            else if (maxTopicWidth[i] >= 4) maxTopicWidth[i] += 1; // Thousands
        }
        for (int i = 0; i < topics.length; i++) { // checks to see if topic title is longer
            if (topics[i].length() > maxTopicWidth[i]) maxTopicWidth[i] = topics[i].length();
        }
        
        int totalRawWidth = 0;
        for (int w : maxTopicWidth) totalRawWidth += w;
        
        // Header row
        table.append("+").append("-".repeat(2*margin*topics.length+totalRawWidth+values.length-1)).append("+\n");
        // Title row
        table.append("|").append(center(title, 2*margin*topics.length+totalRawWidth+values.length-1)).append("|\n");
        // Topic header row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        table.append("\n");
        // Topics
        table.append("|");
        for (int i = 0; i < topics.length; i++) table.append(center(topics[i], 2*margin+maxTopicWidth[i])).append("|");
        table.append("\n");
        // Topic header row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        table.append("\n");
        // Topics numbers
        for (int i = 0; i < values[0].length; i++) {
            table.append("|");
            for (int j = 0; j < values.length; j++) {
                table.append(String.format(" ".repeat(margin)+"%-,"+maxTopicWidth[j]+"d"+" ".repeat(margin)+"|", values[j][i]));
            }
            table.append("\n");
        }
        // Final row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        
        return table.toString();
    }
    
    /**
     * Returns a printout of title, topics and a long argument array under topics
     * in a table format that is equally spaced
     * The value of values.length must equal the value of topics.length.
     * @param values int array of values under topics
     * @return printout
     * @throws IllegalArgumentException values.length != topics.length
     */
    public String print(long[]... values) throws IllegalArgumentException {
        if (values.length != topics.length)
            throw new IllegalArgumentException(values.length+"!="+topics.length);
        
        StringBuilder table = new StringBuilder();
        int[] maxTopicWidth = new int[values.length];
        for (int i = 0; i < values.length; i++) { // Iterate on topics
            for (int j = 0; j < values[i].length; j++) { // Iterate inside topics
                if (String.valueOf(values[i][j]).length() > maxTopicWidth[i])
                    maxTopicWidth[i] = String.valueOf(values[i][j]).length();
            }
        }
        for (int i = 0; i < maxTopicWidth.length; i++) { // Adds commas to the width
            if (maxTopicWidth[i] >= 13) maxTopicWidth[i] += 4; // Trillions
            else if (maxTopicWidth[i] >= 10) maxTopicWidth[i] += 3; // Billions
            else if (maxTopicWidth[i] >= 7) maxTopicWidth[i] += 2; // Millians
            else if (maxTopicWidth[i] >= 4) maxTopicWidth[i] += 1; // Thousands
        }
        for (int i = 0; i < topics.length; i++) { // checks to see if topic title is longer
            if (topics[i].length() > maxTopicWidth[i]) maxTopicWidth[i] = topics[i].length();
        }
        
        int totalRawWidth = 0;
        for (int w : maxTopicWidth) totalRawWidth += w;
        
        // Header row
        table.append("+").append("-".repeat(2*margin*topics.length+totalRawWidth+values.length-1)).append("+\n");
        // Title row
        table.append("|").append(center(title, 2*margin*topics.length+totalRawWidth+values.length-1)).append("|\n");
        // Topic header row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        table.append("\n");
        // Topics
        table.append("|");
        for (int i = 0; i < topics.length; i++) table.append(center(topics[i], 2*margin+maxTopicWidth[i])).append("|");
        table.append("\n");
        // Topic header row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        table.append("\n");
        // Topics numbers
        for (int i = 0; i < values[0].length; i++) {
            table.append("|");
            for (int j = 0; j < values.length; j++) {
                table.append(String.format(" ".repeat(margin)+"%-,"+maxTopicWidth[j]+"d"+" ".repeat(margin)+"|", values[j][i]));
            }
            table.append("\n");
        }
        // Final row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        
        return table.toString();
    }
    
    /**
     * Returns a printout of title, topics and a String argument array under topics
     * in a table format that is equally spaced
     * The value of values.length must equal the value of topics.length.
     * @param values String array of values under topics
     * @return printout
     * @throws IllegalArgumentException values.length != topics.length
     */
    public String print(String[]... values) throws IllegalArgumentException {
        if (values.length != topics.length)
            throw new IllegalArgumentException(values.length+"!="+topics.length);
        
        StringBuilder table = new StringBuilder();
        int[] maxTopicWidth = new int[values.length];
        for (int i = 0; i < values.length; i++) { // Iterate on topics
            for (int j = 0; j < values[i].length; j++) { // Iterate inside topics
                if (values[i][j].length() > maxTopicWidth[i])
                    maxTopicWidth[i] = values[i][j].length();
            }
        }
        for (int i = 0; i < topics.length; i++) { // checks to see if topic title is longer
            if (topics[i].length() > maxTopicWidth[i]) maxTopicWidth[i] = topics[i].length();
        }
        
        int totalRawWidth = 0;
        for (int w : maxTopicWidth) totalRawWidth += w;
        
        // Header row
        table.append("+").append("-".repeat(2*margin*topics.length+totalRawWidth+values.length-1)).append("+\n");
        // Title row
        table.append("|").append(center(title, 2*margin*topics.length+totalRawWidth+values.length-1)).append("|\n");
        // Topic header row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        table.append("\n");
        // Topics
        table.append("|");
        for (int i = 0; i < topics.length; i++) table.append(center(topics[i], 2*margin+maxTopicWidth[i])).append("|");
        table.append("\n");
        // Topic header row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        table.append("\n");
        // Topics numbers
        for (int i = 0; i < values[0].length; i++) {
            table.append("|");
            for (int j = 0; j < values.length; j++) {
                table.append(String.format(" ".repeat(margin)+"%-"+maxTopicWidth[j]+"s"+" ".repeat(margin)+"|", values[j][i]));
            }
            table.append("\n");
        }
        // Final row
        table.append("+");
        for (int i = 0; i < topics.length; i++) table.append("-".repeat(maxTopicWidth[i]+(2*margin))).append("+");
        
        return table.toString();
    }
    
    /**
     * Code used from StackOverflow.
     * Question: https://stackoverflow.com/questions/8154366/how-to-center-a-string-using-string-format
     * Center aligns a string.
     * 
     * @author Mertuarez
     * @param text text
     * @param len length
     * @return centered text
     */
    private String center(String text, int len){
        String out = String.format("%"+len+"s%s%"+len+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len; 
        return out.substring((int)start, (int)end);
    }
    
    /**
     * Returns title.
     * @return title
     */
    public String getTitle() { return title; }
    
    /**
     * Sets title.
     * @param t title
     */
    public void setTitle(String t) { title = t; }
    
    /**
     * Returns topics.
     * @return topics
     */
    public String[] getTopics() { return topics; }
    
    /**
     * Sets a new list of topics.
     * @param ts topics
     */
    public void setTopics(String... ts) { topics = ts; }
    
    /**
     * Sets a topic at index i.
     * @param i index
     * @param s topic
     */
    public void setTopic(int i, String s) { topics[i] = s; }
    
}
