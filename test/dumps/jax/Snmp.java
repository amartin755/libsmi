/*
 * This Java file has been generated by smidump 0.2.7. Do not edit!
 * It is intended to be used within a Java AgentX sub-agent environment.
 *
 * $Id$
 */

/**
    This class represents a Java AgentX (JAX) implementation of
    the scalar group snmp defined in SNMPv2-MIB.

    @version 1
    @author  smidump 0.2.7
    @see     AgentXGroup, AgentXScalars
 */

import java.util.Vector;
import java.util.Enumeration;
import jax.AgentXOID;
import jax.AgentXVarBind;
import jax.AgentXSetPhase;
import jax.AgentXResponsePDU;
import jax.AgentXScalars;

public class Snmp extends AgentXScalars
{

    private final static long[] SnmpOID = {1, 3, 6, 1, 2, 1, 11};

    protected AgentXOID SnmpInPktsOID;
    protected final static long[] SnmpInPktsName = {1, 3, 6, 1, 2, 1, 11, 1, 0};
    protected long snmpInPkts = 0;
    protected AgentXOID SnmpOutPktsOID;
    protected final static long[] SnmpOutPktsName = {1, 3, 6, 1, 2, 1, 11, 2, 0};
    protected long snmpOutPkts = 0;
    protected AgentXOID SnmpInBadVersionsOID;
    protected final static long[] SnmpInBadVersionsName = {1, 3, 6, 1, 2, 1, 11, 3, 0};
    protected long snmpInBadVersions = 0;
    protected AgentXOID SnmpInBadCommunityNamesOID;
    protected final static long[] SnmpInBadCommunityNamesName = {1, 3, 6, 1, 2, 1, 11, 4, 0};
    protected long snmpInBadCommunityNames = 0;
    protected AgentXOID SnmpInBadCommunityUsesOID;
    protected final static long[] SnmpInBadCommunityUsesName = {1, 3, 6, 1, 2, 1, 11, 5, 0};
    protected long snmpInBadCommunityUses = 0;
    protected AgentXOID SnmpInASNParseErrsOID;
    protected final static long[] SnmpInASNParseErrsName = {1, 3, 6, 1, 2, 1, 11, 6, 0};
    protected long snmpInASNParseErrs = 0;
    protected AgentXOID SnmpInTooBigsOID;
    protected final static long[] SnmpInTooBigsName = {1, 3, 6, 1, 2, 1, 11, 8, 0};
    protected long snmpInTooBigs = 0;
    protected AgentXOID SnmpInNoSuchNamesOID;
    protected final static long[] SnmpInNoSuchNamesName = {1, 3, 6, 1, 2, 1, 11, 9, 0};
    protected long snmpInNoSuchNames = 0;
    protected AgentXOID SnmpInBadValuesOID;
    protected final static long[] SnmpInBadValuesName = {1, 3, 6, 1, 2, 1, 11, 10, 0};
    protected long snmpInBadValues = 0;
    protected AgentXOID SnmpInReadOnlysOID;
    protected final static long[] SnmpInReadOnlysName = {1, 3, 6, 1, 2, 1, 11, 11, 0};
    protected long snmpInReadOnlys = 0;
    protected AgentXOID SnmpInGenErrsOID;
    protected final static long[] SnmpInGenErrsName = {1, 3, 6, 1, 2, 1, 11, 12, 0};
    protected long snmpInGenErrs = 0;
    protected AgentXOID SnmpInTotalReqVarsOID;
    protected final static long[] SnmpInTotalReqVarsName = {1, 3, 6, 1, 2, 1, 11, 13, 0};
    protected long snmpInTotalReqVars = 0;
    protected AgentXOID SnmpInTotalSetVarsOID;
    protected final static long[] SnmpInTotalSetVarsName = {1, 3, 6, 1, 2, 1, 11, 14, 0};
    protected long snmpInTotalSetVars = 0;
    protected AgentXOID SnmpInGetRequestsOID;
    protected final static long[] SnmpInGetRequestsName = {1, 3, 6, 1, 2, 1, 11, 15, 0};
    protected long snmpInGetRequests = 0;
    protected AgentXOID SnmpInGetNextsOID;
    protected final static long[] SnmpInGetNextsName = {1, 3, 6, 1, 2, 1, 11, 16, 0};
    protected long snmpInGetNexts = 0;
    protected AgentXOID SnmpInSetRequestsOID;
    protected final static long[] SnmpInSetRequestsName = {1, 3, 6, 1, 2, 1, 11, 17, 0};
    protected long snmpInSetRequests = 0;
    protected AgentXOID SnmpInGetResponsesOID;
    protected final static long[] SnmpInGetResponsesName = {1, 3, 6, 1, 2, 1, 11, 18, 0};
    protected long snmpInGetResponses = 0;
    protected AgentXOID SnmpInTrapsOID;
    protected final static long[] SnmpInTrapsName = {1, 3, 6, 1, 2, 1, 11, 19, 0};
    protected long snmpInTraps = 0;
    protected AgentXOID SnmpOutTooBigsOID;
    protected final static long[] SnmpOutTooBigsName = {1, 3, 6, 1, 2, 1, 11, 20, 0};
    protected long snmpOutTooBigs = 0;
    protected AgentXOID SnmpOutNoSuchNamesOID;
    protected final static long[] SnmpOutNoSuchNamesName = {1, 3, 6, 1, 2, 1, 11, 21, 0};
    protected long snmpOutNoSuchNames = 0;
    protected AgentXOID SnmpOutBadValuesOID;
    protected final static long[] SnmpOutBadValuesName = {1, 3, 6, 1, 2, 1, 11, 22, 0};
    protected long snmpOutBadValues = 0;
    protected AgentXOID SnmpOutGenErrsOID;
    protected final static long[] SnmpOutGenErrsName = {1, 3, 6, 1, 2, 1, 11, 24, 0};
    protected long snmpOutGenErrs = 0;
    protected AgentXOID SnmpOutGetRequestsOID;
    protected final static long[] SnmpOutGetRequestsName = {1, 3, 6, 1, 2, 1, 11, 25, 0};
    protected long snmpOutGetRequests = 0;
    protected AgentXOID SnmpOutGetNextsOID;
    protected final static long[] SnmpOutGetNextsName = {1, 3, 6, 1, 2, 1, 11, 26, 0};
    protected long snmpOutGetNexts = 0;
    protected AgentXOID SnmpOutSetRequestsOID;
    protected final static long[] SnmpOutSetRequestsName = {1, 3, 6, 1, 2, 1, 11, 27, 0};
    protected long snmpOutSetRequests = 0;
    protected AgentXOID SnmpOutGetResponsesOID;
    protected final static long[] SnmpOutGetResponsesName = {1, 3, 6, 1, 2, 1, 11, 28, 0};
    protected long snmpOutGetResponses = 0;
    protected AgentXOID SnmpOutTrapsOID;
    protected final static long[] SnmpOutTrapsName = {1, 3, 6, 1, 2, 1, 11, 29, 0};
    protected long snmpOutTraps = 0;
    protected AgentXOID SnmpEnableAuthenTrapsOID;
    protected final static long[] SnmpEnableAuthenTrapsName = {1, 3, 6, 1, 2, 1, 11, 30, 0};
    protected int snmpEnableAuthenTraps = 0;
    protected int undo_snmpEnableAuthenTraps = 0;
    protected AgentXOID SnmpSilentDropsOID;
    protected final static long[] SnmpSilentDropsName = {1, 3, 6, 1, 2, 1, 11, 31, 0};
    protected long snmpSilentDrops = 0;
    protected AgentXOID SnmpProxyDropsOID;
    protected final static long[] SnmpProxyDropsName = {1, 3, 6, 1, 2, 1, 11, 32, 0};
    protected long snmpProxyDrops = 0;
    public Snmp()
    {
        oid = new AgentXOID(SnmpOID);
        data = new Vector();
        SnmpInPktsOID = new AgentXOID(SnmpInPktsName);
        data.addElement(SnmpInPktsOID);
        SnmpOutPktsOID = new AgentXOID(SnmpOutPktsName);
        data.addElement(SnmpOutPktsOID);
        SnmpInBadVersionsOID = new AgentXOID(SnmpInBadVersionsName);
        data.addElement(SnmpInBadVersionsOID);
        SnmpInBadCommunityNamesOID = new AgentXOID(SnmpInBadCommunityNamesName);
        data.addElement(SnmpInBadCommunityNamesOID);
        SnmpInBadCommunityUsesOID = new AgentXOID(SnmpInBadCommunityUsesName);
        data.addElement(SnmpInBadCommunityUsesOID);
        SnmpInASNParseErrsOID = new AgentXOID(SnmpInASNParseErrsName);
        data.addElement(SnmpInASNParseErrsOID);
        SnmpInTooBigsOID = new AgentXOID(SnmpInTooBigsName);
        data.addElement(SnmpInTooBigsOID);
        SnmpInNoSuchNamesOID = new AgentXOID(SnmpInNoSuchNamesName);
        data.addElement(SnmpInNoSuchNamesOID);
        SnmpInBadValuesOID = new AgentXOID(SnmpInBadValuesName);
        data.addElement(SnmpInBadValuesOID);
        SnmpInReadOnlysOID = new AgentXOID(SnmpInReadOnlysName);
        data.addElement(SnmpInReadOnlysOID);
        SnmpInGenErrsOID = new AgentXOID(SnmpInGenErrsName);
        data.addElement(SnmpInGenErrsOID);
        SnmpInTotalReqVarsOID = new AgentXOID(SnmpInTotalReqVarsName);
        data.addElement(SnmpInTotalReqVarsOID);
        SnmpInTotalSetVarsOID = new AgentXOID(SnmpInTotalSetVarsName);
        data.addElement(SnmpInTotalSetVarsOID);
        SnmpInGetRequestsOID = new AgentXOID(SnmpInGetRequestsName);
        data.addElement(SnmpInGetRequestsOID);
        SnmpInGetNextsOID = new AgentXOID(SnmpInGetNextsName);
        data.addElement(SnmpInGetNextsOID);
        SnmpInSetRequestsOID = new AgentXOID(SnmpInSetRequestsName);
        data.addElement(SnmpInSetRequestsOID);
        SnmpInGetResponsesOID = new AgentXOID(SnmpInGetResponsesName);
        data.addElement(SnmpInGetResponsesOID);
        SnmpInTrapsOID = new AgentXOID(SnmpInTrapsName);
        data.addElement(SnmpInTrapsOID);
        SnmpOutTooBigsOID = new AgentXOID(SnmpOutTooBigsName);
        data.addElement(SnmpOutTooBigsOID);
        SnmpOutNoSuchNamesOID = new AgentXOID(SnmpOutNoSuchNamesName);
        data.addElement(SnmpOutNoSuchNamesOID);
        SnmpOutBadValuesOID = new AgentXOID(SnmpOutBadValuesName);
        data.addElement(SnmpOutBadValuesOID);
        SnmpOutGenErrsOID = new AgentXOID(SnmpOutGenErrsName);
        data.addElement(SnmpOutGenErrsOID);
        SnmpOutGetRequestsOID = new AgentXOID(SnmpOutGetRequestsName);
        data.addElement(SnmpOutGetRequestsOID);
        SnmpOutGetNextsOID = new AgentXOID(SnmpOutGetNextsName);
        data.addElement(SnmpOutGetNextsOID);
        SnmpOutSetRequestsOID = new AgentXOID(SnmpOutSetRequestsName);
        data.addElement(SnmpOutSetRequestsOID);
        SnmpOutGetResponsesOID = new AgentXOID(SnmpOutGetResponsesName);
        data.addElement(SnmpOutGetResponsesOID);
        SnmpOutTrapsOID = new AgentXOID(SnmpOutTrapsName);
        data.addElement(SnmpOutTrapsOID);
        SnmpEnableAuthenTrapsOID = new AgentXOID(SnmpEnableAuthenTrapsName);
        data.addElement(SnmpEnableAuthenTrapsOID);
        SnmpSilentDropsOID = new AgentXOID(SnmpSilentDropsName);
        data.addElement(SnmpSilentDropsOID);
        SnmpProxyDropsOID = new AgentXOID(SnmpProxyDropsName);
        data.addElement(SnmpProxyDropsOID);
    }

    public long get_snmpInPkts()
    {
        return snmpInPkts;
    }

    public long get_snmpOutPkts()
    {
        return snmpOutPkts;
    }

    public long get_snmpInBadVersions()
    {
        return snmpInBadVersions;
    }

    public long get_snmpInBadCommunityNames()
    {
        return snmpInBadCommunityNames;
    }

    public long get_snmpInBadCommunityUses()
    {
        return snmpInBadCommunityUses;
    }

    public long get_snmpInASNParseErrs()
    {
        return snmpInASNParseErrs;
    }

    public long get_snmpInTooBigs()
    {
        return snmpInTooBigs;
    }

    public long get_snmpInNoSuchNames()
    {
        return snmpInNoSuchNames;
    }

    public long get_snmpInBadValues()
    {
        return snmpInBadValues;
    }

    public long get_snmpInReadOnlys()
    {
        return snmpInReadOnlys;
    }

    public long get_snmpInGenErrs()
    {
        return snmpInGenErrs;
    }

    public long get_snmpInTotalReqVars()
    {
        return snmpInTotalReqVars;
    }

    public long get_snmpInTotalSetVars()
    {
        return snmpInTotalSetVars;
    }

    public long get_snmpInGetRequests()
    {
        return snmpInGetRequests;
    }

    public long get_snmpInGetNexts()
    {
        return snmpInGetNexts;
    }

    public long get_snmpInSetRequests()
    {
        return snmpInSetRequests;
    }

    public long get_snmpInGetResponses()
    {
        return snmpInGetResponses;
    }

    public long get_snmpInTraps()
    {
        return snmpInTraps;
    }

    public long get_snmpOutTooBigs()
    {
        return snmpOutTooBigs;
    }

    public long get_snmpOutNoSuchNames()
    {
        return snmpOutNoSuchNames;
    }

    public long get_snmpOutBadValues()
    {
        return snmpOutBadValues;
    }

    public long get_snmpOutGenErrs()
    {
        return snmpOutGenErrs;
    }

    public long get_snmpOutGetRequests()
    {
        return snmpOutGetRequests;
    }

    public long get_snmpOutGetNexts()
    {
        return snmpOutGetNexts;
    }

    public long get_snmpOutSetRequests()
    {
        return snmpOutSetRequests;
    }

    public long get_snmpOutGetResponses()
    {
        return snmpOutGetResponses;
    }

    public long get_snmpOutTraps()
    {
        return snmpOutTraps;
    }

    public int get_snmpEnableAuthenTraps()
    {
        return snmpEnableAuthenTraps;
    }

    public int set_snmpEnableAuthenTraps(AgentXSetPhase phase, int value)
    {
        switch (phase.getPhase()) {
        case AgentXSetPhase.TEST_SET:
            break;
        case AgentXSetPhase.COMMIT:
            undo_snmpEnableAuthenTraps = snmpEnableAuthenTraps;
            snmpEnableAuthenTraps = value;
            break;
        case AgentXSetPhase.UNDO:
            snmpEnableAuthenTraps = undo_snmpEnableAuthenTraps;
            break;
        case AgentXSetPhase.CLEANUP:
            break;
        default:
            return AgentXResponsePDU.PROCESSING_ERROR;
        }
        return AgentXResponsePDU.NO_ERROR;
    }
    public long get_snmpSilentDrops()
    {
        return snmpSilentDrops;
    }

    public long get_snmpProxyDrops()
    {
        return snmpProxyDrops;
    }

    public AgentXVarBind getScalar(AgentXOID pos, AgentXOID oid)
    {
        if ((pos == null) || (pos.compareTo(oid) != 0))
            return new AgentXVarBind(oid, AgentXVarBind.NOSUCHOBJECT);
        else {
            if (pos == SnmpInPktsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInPkts());
            if (pos == SnmpOutPktsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutPkts());
            if (pos == SnmpInBadVersionsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadVersions());
            if (pos == SnmpInBadCommunityNamesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadCommunityNames());
            if (pos == SnmpInBadCommunityUsesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadCommunityUses());
            if (pos == SnmpInASNParseErrsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInASNParseErrs());
            if (pos == SnmpInTooBigsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInTooBigs());
            if (pos == SnmpInNoSuchNamesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInNoSuchNames());
            if (pos == SnmpInBadValuesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadValues());
            if (pos == SnmpInReadOnlysOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInReadOnlys());
            if (pos == SnmpInGenErrsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInGenErrs());
            if (pos == SnmpInTotalReqVarsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInTotalReqVars());
            if (pos == SnmpInTotalSetVarsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInTotalSetVars());
            if (pos == SnmpInGetRequestsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInGetRequests());
            if (pos == SnmpInGetNextsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInGetNexts());
            if (pos == SnmpInSetRequestsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInSetRequests());
            if (pos == SnmpInGetResponsesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInGetResponses());
            if (pos == SnmpInTrapsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpInTraps());
            if (pos == SnmpOutTooBigsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutTooBigs());
            if (pos == SnmpOutNoSuchNamesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutNoSuchNames());
            if (pos == SnmpOutBadValuesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutBadValues());
            if (pos == SnmpOutGenErrsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGenErrs());
            if (pos == SnmpOutGetRequestsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGetRequests());
            if (pos == SnmpOutGetNextsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGetNexts());
            if (pos == SnmpOutSetRequestsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutSetRequests());
            if (pos == SnmpOutGetResponsesOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGetResponses());
            if (pos == SnmpOutTrapsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpOutTraps());
            if (pos == SnmpEnableAuthenTrapsOID)
                return new AgentXVarBind(oid, AgentXVarBind.INTEGER, 
                                         get_snmpEnableAuthenTraps());
            if (pos == SnmpSilentDropsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpSilentDrops());
            if (pos == SnmpProxyDropsOID)
                return new AgentXVarBind(oid, AgentXVarBind.COUNTER32, 
                                         get_snmpProxyDrops());
        }
        return new AgentXVarBind(oid, AgentXVarBind.NOSUCHOBJECT);
    }

    public int setScalar(AgentXSetPhase phase, AgentXOID pos,
                         AgentXVarBind inVb)
    {
        if ((pos == null) || (pos.compareTo(inVb.getOID()) != 0))
            return AgentXResponsePDU.INCONSISTENT_NAME;
        else {
            if (pos == SnmpEnableAuthenTrapsOID)
                return set_snmpEnableAuthenTraps(phase, inVb.intValue());
        }
        return AgentXResponsePDU.NOT_WRITABLE;
    }

    public AgentXVarBind getNextScalar(AgentXOID pos, AgentXOID oid)
    {
        if ((pos == null) || (pos.compareTo(oid) <= 0))
            return new AgentXVarBind(oid, AgentXVarBind.ENDOFMIBVIEW);
        else {
            if (pos == SnmpInPktsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInPkts());
            if (pos == SnmpOutPktsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutPkts());
            if (pos == SnmpInBadVersionsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadVersions());
            if (pos == SnmpInBadCommunityNamesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadCommunityNames());
            if (pos == SnmpInBadCommunityUsesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadCommunityUses());
            if (pos == SnmpInASNParseErrsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInASNParseErrs());
            if (pos == SnmpInTooBigsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInTooBigs());
            if (pos == SnmpInNoSuchNamesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInNoSuchNames());
            if (pos == SnmpInBadValuesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInBadValues());
            if (pos == SnmpInReadOnlysOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInReadOnlys());
            if (pos == SnmpInGenErrsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInGenErrs());
            if (pos == SnmpInTotalReqVarsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInTotalReqVars());
            if (pos == SnmpInTotalSetVarsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInTotalSetVars());
            if (pos == SnmpInGetRequestsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInGetRequests());
            if (pos == SnmpInGetNextsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInGetNexts());
            if (pos == SnmpInSetRequestsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInSetRequests());
            if (pos == SnmpInGetResponsesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInGetResponses());
            if (pos == SnmpInTrapsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpInTraps());
            if (pos == SnmpOutTooBigsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutTooBigs());
            if (pos == SnmpOutNoSuchNamesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutNoSuchNames());
            if (pos == SnmpOutBadValuesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutBadValues());
            if (pos == SnmpOutGenErrsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGenErrs());
            if (pos == SnmpOutGetRequestsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGetRequests());
            if (pos == SnmpOutGetNextsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGetNexts());
            if (pos == SnmpOutSetRequestsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutSetRequests());
            if (pos == SnmpOutGetResponsesOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutGetResponses());
            if (pos == SnmpOutTrapsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpOutTraps());
            if (pos == SnmpEnableAuthenTrapsOID)
                return new AgentXVarBind(pos, AgentXVarBind.INTEGER, 
                                         get_snmpEnableAuthenTraps());
            if (pos == SnmpSilentDropsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpSilentDrops());
            if (pos == SnmpProxyDropsOID)
                return new AgentXVarBind(pos, AgentXVarBind.COUNTER32, 
                                         get_snmpProxyDrops());
        }
        return new AgentXVarBind(pos, AgentXVarBind.ENDOFMIBVIEW);
    }

}

