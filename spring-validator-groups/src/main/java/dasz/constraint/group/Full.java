package dasz.constraint.group;

import javax.validation.GroupSequence;

@GroupSequence({Draft.class, Complete.class})
public interface Full {
}
