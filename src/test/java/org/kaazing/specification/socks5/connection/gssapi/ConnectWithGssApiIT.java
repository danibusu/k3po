/*
 * Copyright 2014, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaazing.specification.socks5.connection.gssapi;

/**
 * SOCKS5 - RFC 1928, section 3 "Procedure for TCP-based clients" using method 0x01 and
 *          RFC 1961 "GSS-API Authentication Method for SOCKS Version 5"
 */
public class ConnectWithGssApiIT {
    // need agreed upon credentials (joe/welcome, perhaps?)
    // 
    // need functions for client side establishment
//    
//    GSSManager manager = GSSManager.getInstance();
//    GSSName serverName = manager.createName(server, null);
//    
//    GSSContext context = 
//            manager.createContext(serverName,
//                                  krb5Oid,
//                                  null,
//                                  GSSContext.DEFAULT_LIFETIME);
//    
//    context.requestMutualAuth(true);  // Mutual authentication
//    context.requestConf(true);  // Will use encryption later
//    context.requestInteg(true); // Will use integrity later
//
//    byte[] token = new byte[0];
//
//    while (!context.isEstablished()) {
//
//        // token is ignored on the first call
//        token = context.initSecContext(token, 0, token.length);
//
//        // Send a token to the server if one was generated by
//        // initSecContext
//        if (token != null) {
//            System.out.println("Will send token of size "
//                       + token.length + " from initSecContext.");
//            outStream.writeInt(token.length);
//            outStream.write(token);
//            outStream.flush();
//        }
//
//        // If the client is done with context establishment
//        // then there will be no more tokens to read in this loop
//        if (!context.isEstablished()) {
//            token = new byte[inStream.readInt()];
//            System.out.println("Will read input token of size "
//                       + token.length
//                       + " for processing by initSecContext");
//            inStream.readFully(token);
//        }
//    }
//
//    System.out.println("Context Established! ");
//    System.out.println("Client is " + context.getSrcName());
//    System.out.println("Server is " + context.getTargName());
//    if (context.getMutualAuthState())
//        System.out.println("Mutual authentication took place!");


    // need function for server side establishment
//    GSSManager manager = GSSManager.getInstance();
//
//    GSSContext context = manager.createContext((GSSCredential)null);
//
//    byte[] token = null;
//
//    while (!context.isEstablished()) {
//
//        token = new byte[inStream.readInt()];
//        System.out.println("Will read input token of size "
//           + token.length
//           + " for processing by acceptSecContext");
//        inStream.readFully(token);
//        
//        token = context.acceptSecContext(token, 0, token.length);
//        
//        // Send a token to the peer if one was generated by
//        // acceptSecContext
//        if (token != null) {
//            System.out.println("Will send token of size "
//               + token.length
//               + " from acceptSecContext.");
//            outStream.writeInt(token.length);
//            outStream.write(token);
//            outStream.flush();
//        }
//    }
//
//    System.out.print("Context Established! ");
//    System.out.println("Client is " + context.getSrcName());
//    System.out.println("Server is " + context.getTargName());
//    if (context.getMutualAuthState())
//        System.out.println("Mutual authentication took place!");


// more info at: http://docs.oracle.com/javase/7/docs/technotes/guides/security/jgss/tutorials/BasicClientServer.html#ExchangeMsgs
    
    // The final algorithm for the client will be
    //    - create the GSSContext
    //    - create a dummy token
    //    - send the dummy token
    //    - loop:
    //        - read the real token back from server
    //        - apply token to sec context
    //        - write resulting token to server
    //    - end loop: connection established
    //    - send a message: e.g. a BIND request (verify MIC from server???)
    //    - read a response: e.g. BIND established
    //    - read any additional responses required (e.g. 2nd bind meaning a connection has been
    //                                              made to the bind and is being proxied through)

    // The final algorithm for the server will be
    //    - create the GSSContext
    //    - loop:
    //        - read a token from client
    //        - apply token to sec context
    //        - write resulting token to client
    //    - end loop: connection established
    //    - read a message: e.g. a BIND request (send MIC to client???)
    //    - send a response: e.g. BIND established
    //    - send any additional responses required (e.g. 2nd bind meaning a connection has been
    //                                              made to the bind and is being proxied through)
}
