
package estrutraDados;

public class Hash
{

   private int TAMANHO_TABLE = 128;
   private Info[] informacoes;

   public Hash()
   {
      this.informacoes = new Info[TAMANHO_TABLE];
   }

   public void insere(int chave, String valor)
   {
      int hash = chave % TAMANHO_TABLE;

      Info info = informacoes[hash];

      if (info == null)
      {
         informacoes[hash] = new Info(chave, valor);
      }
      else
      {
         while (info.getCorrente() != null && info.getCorrente().getChave() != chave)
         {
            info = info.getCorrente();
         }

         if (info.getChave() == chave)
         {
            info.setValor(valor);
         }
         else
         {
            info.setCorrente(new Info(chave, valor));
         }
      }
   }

   public String recupera(int chave)
   {
      int hash = chave % TAMANHO_TABLE;

      Info info = informacoes[hash];

      if (info != null)
      {
         while (info != null && info.getChave() != chave)
         {
            info = info.getCorrente();
         }

         return info.getValor();
      }

      return null;
   }

   public void remove(int chave)
   {
      int hash = chave % TAMANHO_TABLE;

      Info info = informacoes[hash];

      if (info != null)
      {
         if (info.getChave() == chave)
         {
            informacoes[hash] = info.getCorrente();
         }
         else
         {
            Info anterior = info;
            while (info.getCorrente() != null && info.getChave() != chave)
            {
               anterior = info;
               info = info.getCorrente();
            }
            anterior.setCorrente(info.getCorrente());
         }

      }
   }

   public static void main(String[] args)
   {
      Hash h = new Hash();
      h.insere(1, "opa1");
      h.insere(2, "opa2");
      h.insere(128, "opa128");
      h.insere(256, "opa256");

      h.remove(128);

      h = h;
   }
}
