/*
 * This Java file has been generated by smidump 0.2.17. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table row hostControl2Entry defined in RMON2-MIB.

    @version 1
    @author  smidump 0.2.17
    @see     AgentXTable, AgentXEntry
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class HostControl2Entry extends AgentXEntry
{

    protected long hostControlDroppedFrames = 0;
    protected long hostControlCreateTime = 0;

    public HostControl2Entry()
    {

    }

    public long get_hostControlDroppedFrames()
    {
        return hostControlDroppedFrames;
    }

    public long get_hostControlCreateTime()
    {
        return hostControlCreateTime;
    }

}

