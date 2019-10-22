package seedu.mark.model.annotation;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.mark.commons.core.index.Index;

/**
 * Represents the identifier for a paragraph. Each identifier includes a {@code type} and an {@code index}.
 */
public class ParagraphIdentifier implements Comparable<ParagraphIdentifier> {
    private Index index;
    private ParagraphType type;

    public ParagraphIdentifier(Index idx, ParagraphType type) {
        requireNonNull(idx);
        requireNonNull(type);

        this.index = idx;
        this.type = type;
    }

    /**
     * Returns true if this identifier identifies a phantom paragraph.
     */
    public boolean isStray() {
        return type == ParagraphType.STRAY;
    }

    public Index getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof ParagraphIdentifier
                && ((ParagraphIdentifier) other).index.equals(this.index)
                && ((ParagraphIdentifier) other).type == this.type);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(index.getOneBased(), type);
    }

    @Override
    public int compareTo(ParagraphIdentifier other) {
        if (this.type == ParagraphType.EXIST) {
            if (other.type == ParagraphType.EXIST) {
                return this.index.getOneBased() - other.index.getOneBased();
            } else {
                return -1;
            }
        } else {
            if (other.type == ParagraphType.EXIST) {
                return 1;
            } else {
                return this.index.getOneBased() - other.index.getOneBased();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s%d", type.convert(), index.getOneBased());
    }

    /**
     * Type of paragraph. Paragraphs that {@code EXIST} have content; those that are {@code STRAY} are previously
     * detached from their original paragraphs and currently attached to phantom paragraphs (no content).
     */
    public static enum ParagraphType {
        EXIST, STRAY;

        /**
         * Converts the paragraph type into a single character for easy reference.
         * @return "p" if is true paragraph, else "s" if is phantom
         */
        public String convert() {
            if (this == EXIST) {
                return "P";
            }
            return "S";
        }
    }
}
