package eu.amidst.core.database.statics.readers.impl;

import com.google.common.collect.ImmutableSet;
import eu.amidst.core.database.statics.readers.Attribute;
import eu.amidst.core.database.statics.readers.Attributes;
import eu.amidst.core.database.statics.readers.Kind;

import java.util.Set;

/**
 * Created by sigveh on 10/16/14.
 */
public class ForTesting2Attributes implements Attributes {

    private final Attribute CLASS = new Attribute(0, "CLASS", "NA", Kind.INTEGER);
    private final Attribute TWO_NAMES = new Attribute(0, "TWO NAMES", "NA", Kind.REAL);
    private final Attribute THREE_NAMES_HERE = new Attribute(1, "THREE NAMES HERE", "NA", Kind.REAL);

    private static Set<Attribute> attributes;
    {
        attributes = ImmutableSet.of(CLASS, TWO_NAMES, THREE_NAMES_HERE);
    }

    @Override
    public Set<Attribute> getSet(){
        return attributes;
    }

    @Override
    public void print() {

    }


    public Attribute getCLASS() {
        return CLASS;
    }

    public Attribute getTWO_NAMES() {
        return TWO_NAMES;
    }

    public Attribute getTHREE_NAMES_HERE() {
        return THREE_NAMES_HERE;
    }

}
