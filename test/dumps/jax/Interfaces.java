/*
 * This Java file has been generated by smidump 0.2.11. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the scalar group interfaces defined in IF-MIB.

    @version 1
    @author  smidump 0.2.11
    @see     AgentXGroup, AgentXScalars
 */

import java.util.Vector;
import java.util.Enumeration;
import jax.AgentXOID;
import jax.AgentXVarBind;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXScalars;

public class Interfaces extends AgentXScalars
{

    private final static long[] InterfacesOID = {1, 3, 6, 1, 2, 1, 2};

    protected AgentXOID IfNumberOID;
    protected final static long[] IfNumberName = {1, 3, 6, 1, 2, 1, 2, 1, 0};
    protected int ifNumber = 0;
    public Interfaces()
    {
        oid = new AgentXOID(InterfacesOID);
        data = new Vector();
        IfNumberOID = new AgentXOID(IfNumberName);
        data.addElement(IfNumberOID);
    }

    public int get_ifNumber()
    {
        return ifNumber;
    }

    public AgentXVarBind getScalar(AgentXOID pos, AgentXOID oid)
    {
        if ((pos == null) || (pos.compareTo(oid) != 0))
            return new AgentXVarBind(oid, AgentXVarBind.NOSUCHOBJECT);
        else {
            if (pos == IfNumberOID)
                return new AgentXVarBind(oid, AgentXVarBind.INTEGER, 
                                         get_ifNumber());
        }
        return new AgentXVarBind(oid, AgentXVarBind.NOSUCHOBJECT);
    }

    public int setScalar(AgentXSetPhase phase, AgentXOID pos,
                         AgentXVarBind inVb)
    {
        if ((pos == null) || (pos.compareTo(inVb.getOID()) != 0))
            return AgentXResponsePDU.INCONSISTENT_NAME;
        else {
        }
        return AgentXResponsePDU.NOT_WRITABLE;
    }

    public AgentXVarBind getNextScalar(AgentXOID pos, AgentXOID oid)
    {
        if ((pos == null) || (pos.compareTo(oid) <= 0))
            return new AgentXVarBind(oid, AgentXVarBind.ENDOFMIBVIEW);
        else {
            if (pos == IfNumberOID)
                return new AgentXVarBind(pos, AgentXVarBind.INTEGER, 
                                         get_ifNumber());
        }
        return new AgentXVarBind(pos, AgentXVarBind.ENDOFMIBVIEW);
    }

}

