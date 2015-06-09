/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements.  See the NOTICE file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */

package eu.amidst.corestatic.inference;

import eu.amidst.corestatic.distribution.UnivariateDistribution;
import eu.amidst.corestatic.models.BayesianNetwork;
import eu.amidst.corestatic.variables.Assignment;
import eu.amidst.corestatic.variables.Variable;

/**
 * Created by andresmasegosa on 30/01/15.
 */
public interface InferenceAlgorithmForBN {

    void runInference();

    void setModel(BayesianNetwork model);

    BayesianNetwork getOriginalModel();

    void setEvidence(Assignment assignment);

    <E extends UnivariateDistribution> E getPosterior(Variable var);

    default <E extends UnivariateDistribution> E getPosterior(int varID){
        return this.getPosterior(this.getOriginalModel().getStaticVariables().getVariableById(varID));
    }

    double getLogProbabilityOfEvidence();

    void setSeed(int seed);
}