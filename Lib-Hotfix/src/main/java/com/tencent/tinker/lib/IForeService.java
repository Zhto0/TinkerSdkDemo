package com.tencent.tinker.lib;

/**
 * Created by Stan on 2020-08-11.
 * Email zhanghongtao@mgtv.com
 */
/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/hongtao/Downloads/tinker-1.9.14.7/tinker-android/tinker-android-lib/src/main/aidl/com/tencent/tinker/lib/IForeService.aidl
 */
public interface IForeService extends android.os.IInterface
{
    /** Local-side IPC implementation stub class. */
    public static abstract class Stub extends android.os.Binder implements com.tencent.tinker.lib.IForeService
    {
        private static final java.lang.String DESCRIPTOR = "com.tencent.tinker.lib.IForeService";
        /** Construct the stub at attach it to the interface. */
        public Stub()
        {
            this.attachInterface(this, DESCRIPTOR);
        }
        /**
         * Cast an IBinder object into an com.tencent.tinker.lib.IForeService interface,
         * generating a proxy if needed.
         */
        public static com.tencent.tinker.lib.IForeService asInterface(android.os.IBinder obj)
        {
            if ((obj==null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin!=null)&&(iin instanceof com.tencent.tinker.lib.IForeService))) {
                return ((com.tencent.tinker.lib.IForeService)iin);
            }
            return new com.tencent.tinker.lib.IForeService.Stub.Proxy(obj);
        }
        @Override public android.os.IBinder asBinder()
        {
            return this;
        }
        @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
        {
            java.lang.String descriptor = DESCRIPTOR;
            switch (code)
            {
                case INTERFACE_TRANSACTION:
                {
                    reply.writeString(descriptor);
                    return true;
                }
                case TRANSACTION_startme:
                {
                    data.enforceInterface(descriptor);
                    this.startme();
                    reply.writeNoException();
                    return true;
                }
                default:
                {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }
        private static class Proxy implements com.tencent.tinker.lib.IForeService
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
            @Override public void startme() throws android.os.RemoteException
            {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    mRemote.transact(Stub.TRANSACTION_startme, _data, _reply, 0);
                    _reply.readException();
                }
                finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
        static final int TRANSACTION_startme = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    }
    public void startme() throws android.os.RemoteException;
}
