/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aesh.util.completer;

import org.aesh.command.impl.parser.CommandLineParser;
import org.aesh.utils.Config;


/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public class FileCompleterGenerator {

    public String generateCompeterFile(CommandLineParser command) {
         StringBuilder out = new StringBuilder();

         out.append(generateHeader(command.getProcessedCommand().name()));

         if(command.isGroupCommand())
             out.append(generateChildList(command));

         if(command.getProcessedCommand().getOptions() != null &&
                    command.getProcessedCommand().getOptions().size() > 0) {
            out.append(generateOptionList(command)) ;
         }


         return out.toString();
    }

    private String generateOptionList(CommandLineParser command) {
        StringBuilder options = new StringBuilder();



        return options.toString();
    }

    private String generateChildList(CommandLineParser command) {
        StringBuilder builder = new StringBuilder();
        builder.append(command.getProcessedCommand().name().toLowerCase())
                .append("_child_commands() {")
                .append(Config.getLineSeparator());



        builder.append("}").append(Config.getLineSeparator());

        return builder.toString();
    }

    private String generateHeader(String name) {
        StringBuilder header = new StringBuilder();
        header.append("#!/usr/bin"+Config.getLineSeparator()+Config.getLineSeparator())
                .append("#------------------------------------------")
                .append("Completion support for ").append(name).append(" generated by Æsh.")
                .append(Config.getLineSeparator())
                .append("#------------------------------------------")
                .append(Config.getLineSeparator());

        return header.toString();
    }

    private String generateArrContains() {
	    return "";
    }



}
