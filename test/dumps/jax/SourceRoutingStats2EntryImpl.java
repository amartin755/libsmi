/*
 * This Java file has been generated by smidump 0.2.17. It
 * is intended to be edited by the application programmer and
 * to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class extends the Java AgentX (JAX) implementation of
    the table row sourceRoutingStats2Entry defined in RMON2-MIB.
 */

import jax.AgentXOID;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXEntry;

public class SourceRoutingStats2EntryImpl extends SourceRoutingStats2Entry
{

    // constructor
    public SourceRoutingStats2EntryImpl()
    {
        super();
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

