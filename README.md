# LL-1
Программная реализация [LL(1)](https://ru.wikipedia.org/wiki/LL(1))-разбора

## Первоначальная грмаматика языка
<A> - аксиома
<A>::= <B>|<D>
<B>::= <B><C><C>|a      
<C>::=ba      
<D>::= <C>a<D>|b 
