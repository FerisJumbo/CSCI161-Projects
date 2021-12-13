package lib;

import java.util.Arrays;

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
 * Description of MergeSort
 *
 * @author Cole Gartner
 * @version Nov 26, 2021
 */
public class MergeSort {
    
    /**
     * Splits the array recursivly until trivaly sorted then merges each split
     * array together.
     * @param <K> Type
     * @param S Array
     * @param comp Comparator
     */
    public static <K> void sort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) return; // Array is sorted by default.
        
        // divide
        int mid = n/2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        
        // conquer (with recursion)
        sort(S1, comp); // sort copy of first half
        sort(S2, comp); // sort copy of second half
        
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original
    }
    
    /**
     * Merges two arrays together into one array.
     * @param <K> Type
     * @param S1 Array 1
     * @param S2 Array 2
     * @param S Sort array
     * @param comp Comparator
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i+j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j])  < 0))
                S[i+j] = S1[i++]; // copy ith element of S1 and increment i
            else
                S[i+j] = S2[j++]; // copy jth element of S2 and increment j
        }
    }
    
}
