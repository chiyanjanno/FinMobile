<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateOverallcontributionsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('overallcontributions', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->string('users_id');
            $table->Integer('socialwelfaresid');
            $table->Integer('finesid');
            $table->Integer('loansid');
            //$table->Integer('Interest(15%)');
            //$table->Integer('due_loan_repayment');      
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('overallcontributions');
    }
}
