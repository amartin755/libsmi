/*
 * This Java file has been generated by smidump 0.2.11. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the table row sourceRoutingStats2Entry defined in RMON2-MIB.

    @version 1
    @author  smidump 0.2.11
    @see     AgentXTable, AgentXEntry
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class SourceRoutingStats2Entry extends AgentXEntry
{

    protected long sourceRoutingStatsDroppedFrames = 0;
    protected long sourceRoutingStatsCreateTime = 0;

    public SourceRoutingStats2Entry()
    {

    }

    public long get_sourceRoutingStatsDroppedFrames()
    {
        return sourceRoutingStatsDroppedFrames;
    }

    public long get_sourceRoutingStatsCreateTime()
    {
        return sourceRoutingStatsCreateTime;
    }

}
