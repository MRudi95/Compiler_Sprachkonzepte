/* This file was generated by SableCC (http://www.sablecc.org/). */

package node;

import analysis.*;

@SuppressWarnings("nls")
public final class AMulOp extends POp
{
    private TTimes _times_;

    public AMulOp()
    {
        // Constructor
    }

    public AMulOp(
        @SuppressWarnings("hiding") TTimes _times_)
    {
        // Constructor
        setTimes(_times_);

    }

    @Override
    public Object clone()
    {
        return new AMulOp(
            cloneNode(this._times_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMulOp(this);
    }

    public TTimes getTimes()
    {
        return this._times_;
    }

    public void setTimes(TTimes node)
    {
        if(this._times_ != null)
        {
            this._times_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._times_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._times_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._times_ == child)
        {
            this._times_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._times_ == oldChild)
        {
            setTimes((TTimes) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
