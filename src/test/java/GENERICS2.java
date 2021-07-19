public class GENERICS2 {


}

 interface Service<T,U> {
    T executeService(U... args);
}

 class MyService<T, U>  implements Service<T, U> {


     @Override
     public T executeService(U... args) {
         return null;
     }
 }
