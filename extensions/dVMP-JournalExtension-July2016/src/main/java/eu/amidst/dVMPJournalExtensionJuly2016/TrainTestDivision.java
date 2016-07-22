/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under the License.
 *
 */

package eu.amidst.dVMPJournalExtensionJuly2016;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by andresmasegosa on 22/7/16.
 */
public class TrainTestDivision {

    public static void main(String[] args) throws Exception {
        String data = args[0];

        String train = data.substring(0, data.length() - 5);
        train += "_train.arff";
        String test = data.substring(0, data.length() - 5);
        test += "_test.arff";


        FileWriter fileWriterTrain = new FileWriter(train);
        FileWriter fileWriterTest = new FileWriter(test);


        Path path1 = Paths.get(data);
        Reader source = Files.newBufferedReader(path1);
        BufferedReader reader = new BufferedReader(source);

        Iterator<String> headerLines = reader.lines().iterator();

        while (headerLines.hasNext()) {
            String line = headerLines.next();
            fileWriterTrain.write(line+"\n");
            fileWriterTest.write(line+"\n");

            if (line.compareTo("@data"+"\n")==0)
                break;
        }

        int countTraining = 0;
        while (headerLines.hasNext()) {
            String line = headerLines.next();

            if (countTraining%3==0){
                fileWriterTest.write(line+"\n");
            }else{
                fileWriterTrain.write(line+"\n");
            }
            countTraining++;
        }

        fileWriterTrain.close();
        fileWriterTest.close();
    }
}
