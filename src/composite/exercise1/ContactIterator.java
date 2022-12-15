/*
 * This class forms part of the Design Patterns Course by
 * Dr Heinz Kabutz from JavaSpecialists.eu and may not be
 * distributed without written consent.
 *
 * Copyright 2001-2018, Heinz Kabutz, All rights reserved.
 */
package composite.exercise1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

/**
 * This ContactIterator should iterate through the composite tree structure
 * without first building up a list of elements.  It thus figures out on-the-fly
 * whether there is a next element or not.
 */
public class ContactIterator implements Iterator<Contact> {
    private final Deque<Iterator<Contact>> unfinishedIterators = new ArrayDeque<>();
    private Contact nextContact;
    private Iterator<Contact> lastUsedIterator;

    private final Iterator<Contact> leaves;

    public ContactIterator(Contact contact) {
        ArrayList<Contact> temp = new ArrayList<>();
        findAllLeaves(contact, temp);
        leaves = temp.iterator();
    }

    private void findAllLeaves(Contact contact, ArrayList<Contact> leaves) {
        if (contact.isLeaf()) leaves.add(contact);
        else {
            for (Iterator<Contact> it = contact.children(); it.hasNext(); ) {
                findAllLeaves(it.next(), leaves);
            }
        }
    }

    public boolean hasNext() {
        if (nextContact == null) nextContact = findNextLeaf();
        return nextContact != null;
    }

    private Contact findNextLeaf() {
        // walk down the tree and find the next leaf...
    }

    public Contact next() {
        return leaves.next();
    }

    /**
     * This should throw an IllegalStateException if the root node of the
     * ContactIterator is a leaf; otherwise it should remove the element from
     * the composite tree structure.
     */
    public void remove() {
        throw new UnsupportedOperationException("todo");
    }
}
