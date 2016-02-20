/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\github\\Android-MemoryShare\\src\\com\\alibaba\\laiwang\\android\\IMemoryShare.aidl
 */
package com.alibaba.laiwang.android;
public interface IMemoryShare extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.alibaba.laiwang.android.IMemoryShare
{
private static final java.lang.String DESCRIPTOR = "com.alibaba.laiwang.android.IMemoryShare";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.alibaba.laiwang.android.IMemoryShare interface,
 * generating a proxy if needed.
 */
public static com.alibaba.laiwang.android.IMemoryShare asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.alibaba.laiwang.android.IMemoryShare))) {
return ((com.alibaba.laiwang.android.IMemoryShare)iin);
}
return new com.alibaba.laiwang.android.IMemoryShare.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getShmFD:
{
data.enforceInterface(DESCRIPTOR);
android.os.ParcelFileDescriptor _result = this.getShmFD();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.alibaba.laiwang.android.IMemoryShare
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public android.os.ParcelFileDescriptor getShmFD() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
android.os.ParcelFileDescriptor _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getShmFD, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = android.os.ParcelFileDescriptor.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getShmFD = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public android.os.ParcelFileDescriptor getShmFD() throws android.os.RemoteException;
}
