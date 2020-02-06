<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateUsersTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('users', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->string('first_name');
            $table->string('last_name'); 
            $table->Integer('phone_number');
            $table->string('email')->unique();
            $table->string('current_home_address');
            $table->string('password');
            $table->string('group_post');
            $table->string('group_name');
            $table->string('group_type');
            $table->date('cycle_start_date');
            $table->date('cycle_end_date');
            $table->Integer('number_of_members');            
            $table->timestamp('email_verified_at')->nullable();
            $table->rememberToken();
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
        Schema::dropIfExists('users');
    }
}
